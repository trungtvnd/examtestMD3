package service;

import model.Category;
import model.Product;
import myConnection.MyConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IProductDAO {
    MyConnection myConnection = new MyConnection();


    @Override
    public void insert(Product product, int category) throws SQLException {
        String INSERT_PRODUCT = "insert into product(name, price, quantity, color, describeProduct,idCategory)\n" +
                "VALUES (?, ?, ?, ?, ?, ?);";
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setString(5, product.getDescribe());
            preparedStatement.setInt(6, category);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Product select(int id) {
        Product product = null;
        String SELECT_PRODUCT_BY_ID =
                "SELECT p.id, p.name,p.price, p.quantity, p.color, p.describeProduct, c.name\n" +
                        "FROM product p\n" +
                        "JOIN category c ON c.id = p.idCategory\n" +
                        "WHERE p.id = ?";
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString(2);
                double price = resultSet.getDouble(3);
                int quantity = resultSet.getInt(4);
                String color = resultSet.getString(5);
                String describe = resultSet.getString(6);
                String Category = resultSet.getString(7);
                product = new Product(id, name, price, quantity, color, describe, Category);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return product;
    }

    @Override
    public List<Product> selectAll() {
        String SELECT_ALL_PRODUCT = "SELECT p.id, p.name,p.price, p.quantity, p.color, p.describeProduct, c.name\n" +
                "FROM product p\n" +
                "JOIN category c ON c.id = p.idCategory\n";
        List<Product> products = new ArrayList<>();
        try (Connection connection = myConnection.getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT)) {
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                double price = resultSet.getDouble(3);
                String nameProduct = resultSet.getString(2);
                int quantity = resultSet.getInt(4);
                String color = resultSet.getString(5);
                String describe = resultSet.getString(6);
                String Category = resultSet.getString(7);
                products.add(new Product(id, nameProduct, price, quantity, color, describe, Category));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return products;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        String DELETE_PRODUCT = "delete from product where id = ?;";
        boolean rowDeleted;
        try (Connection connection = myConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_PRODUCT)) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean edit(Product product, int idCategory) throws SQLException {
        boolean rowUpdated;
        String UPDATE_PRODUCT = "UPDATE product SET name=?, price=?, quantity=?, color=?, describeProduct=?, idCategory=? WHERE id=?";
        try (Connection connection = myConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_PRODUCT);) {
            statement.setString(1, product.getName());
            statement.setDouble(2, product.getPrice());
            statement.setInt(3, product.getQuantity());
            statement.setString(4, product.getColor());
            statement.setString(5, product.getDescribe());
            statement.setInt(6, idCategory);
            statement.setInt(7, product.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    public List<Category> selectAllCategory() {
        String SELECT_ALL_CATEGORY = "SELECT * FROM category";
        List<Category> categories = new ArrayList<>();
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CATEGORY);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                categories.add(new Category(id, name));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return categories;

    }

    public List<Product> searchByName(String name) {
        List<Product> products = new ArrayList<>();
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(" SELECT *\n" +
                    " FROM product \n" +
                    " Where name like ? ");
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                double price = resultSet.getDouble(3);
                String nameProduct = resultSet.getString(2);
                int quantity = resultSet.getInt(4);
                String color = resultSet.getString(5);
                String describe = resultSet.getString(6);
                String Category = resultSet.getString(7);
                products.add(new Product(id, nameProduct, price, quantity, color, describe, Category));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }return products;


    }

}

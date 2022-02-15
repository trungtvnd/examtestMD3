package service;

import model.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProductDAO {
    void insert(Product product, int category) throws SQLException;
    Product select(int id);
    List<Product> selectAll();
    boolean delete(int id) throws SQLException;
    boolean edit(Product product, int idCategory) throws SQLException;
}

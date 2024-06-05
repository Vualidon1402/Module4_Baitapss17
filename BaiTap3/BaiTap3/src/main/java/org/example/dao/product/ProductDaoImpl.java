package org.example.dao.product;

import org.example.model.Category;
import org.example.model.Product;
import org.example.ulti.ConnectDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements IProductDao {
    @Override
    public List<Product> findAllProduct() {
        List<Product> products = new ArrayList<>();
        Connection conn = ConnectDB.connection();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from product");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Category category = new Category(rs.getInt("category_id"), null, false);
                Product product = new Product(
                        rs.getInt("id"),
                        rs.getInt("category_id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("totalPages"),
                        rs.getDate("yearCreated"),
                        rs.getString("author"),
                        rs.getBoolean("status")
                );
                products.add(product);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            ConnectDB.closeConnection(conn);
        }
        return products;
    }

    @Override
    public Product findByIdProduct(Integer id) {
        Product product = null;
        Connection conn = ConnectDB.connection();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from product where id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Category category = new Category(rs.getInt("category_id"), null, false);
                product = new Product(

                        rs.getInt("id"),
                        rs.getInt("category_id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("totalPages"),
                        rs.getDate("yearCreated"),
                        rs.getString("author"),
                        rs.getBoolean("status")
                );
            }
            return product;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            ConnectDB.closeConnection(conn);
        }
    }




    @Override
    public void saveProduct(Product product) {
        Connection conn = ConnectDB.connection();
        CallableStatement callableStatement = null;
        try {
           if (product.getProduct_id() == null) {
               callableStatement = conn.prepareCall("insert into product (category_id, name, price, totalPages, yearCreated, author, status) values (?,?,?,?,?,?,?)");
               callableStatement.setInt(1, product.getCategory_id());
               callableStatement.setString(2, product.getProduct_name());
               callableStatement.setDouble(3, product.getProduct_price());
               callableStatement.setInt(4, product.getTotalPages());
               callableStatement.setDate(5, product.getYearCreate());
               callableStatement.setString(6, product.getProduct_author());
               callableStatement.setBoolean(7, product.isProduct_status());
               callableStatement.executeUpdate();
               System.out.println(callableStatement);
           } else {
               callableStatement = conn.prepareCall("update product set category_id = ?, name = ?, price = ?, totalPages = ?, yearCreated = ?, author = ?, status = ? where id = ?");
                callableStatement.setInt(1, product.getCategory_id());
                callableStatement.setString(2, product.getProduct_name());
                callableStatement.setDouble(3, product.getProduct_price());
                callableStatement.setInt(4, product.getTotalPages());
                callableStatement.setDate(5, product.getYearCreate());
                callableStatement.setString(6, product.getProduct_author());
                callableStatement.setBoolean(7, product.isProduct_status());
                callableStatement.setInt(8, product.getProduct_id());
               callableStatement.executeUpdate();
               System.out.println(callableStatement);
           }


        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            ConnectDB.closeConnection(conn);
        }
    }

    @Override
    public void deleteByIdProduct(Integer id) {
        Connection conn = ConnectDB.connection();
        try {
            PreparedStatement ps = conn.prepareStatement("delete from product where id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            ConnectDB.closeConnection(conn);
        }
    }
}

package dao;

import java.sql.Blob;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import dto.ProductDto;
import dto.SellerDto;

public class ProductDao
{
  
	public Connection getConnection() throws ClassNotFoundException, SQLException
  {
	  Class.forName("com.mysql.cj.jdbc.Driver");
	  return DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdata?user=root&password=root@123");

  }
	
	public int saveProduct(ProductDto product) throws SQLException, ClassNotFoundException
	{
		Connection con = getConnection();
		PreparedStatement pst = con.prepareStatement("insert into product values(?,?,?,?,?,?)");
		
		pst.setInt(1, product.getId());
		pst.setString(2, product.getName());
		pst.setDouble(3, product.getPrice());
		pst.setString(4, product.getBrand());
		pst.setDouble(5, product.getDiscount());
	    Blob image = new SerialBlob(product.getImage());
	    pst.setBlob(6, image);
	    
	    return pst.executeUpdate();
	}

	public int updateProduct(ProductDto product) throws ClassNotFoundException, SQLException
	{
		
		Connection con = getConnection();
		PreparedStatement pst = con.prepareStatement("update product set name=?, price=?, brand=?, discount=?, image=? where id=?");
		
		pst.setInt(6, product.getId());
		pst.setString(1, product.getName());
		pst.setDouble(2, product.getPrice());
		pst.setString(3, product.getBrand());
		pst.setDouble(4, product.getDiscount());
	    Blob image = new SerialBlob(product.getImage());
	    pst.setBlob(5, image);
		
	    return pst.executeUpdate();
		
	}
	
	public int deleteProduct(int id) throws ClassNotFoundException, SQLException
	{
		 Connection con = getConnection();
	       
	     PreparedStatement pst = con.prepareStatement("delete from product where id = ?");
	     pst.setInt(1, id);
	    
	     return pst.executeUpdate();
	}
	
	public ProductDto findById(int id) throws ClassNotFoundException, SQLException
	{
	      Connection con = getConnection();
	       
	      PreparedStatement pst = con.prepareStatement("select * from product where id = ?");
	 	  pst.setInt(1, id);
	 	  
	 	  ResultSet rs = pst.executeQuery();
	 	  
	 	  rs.next();
	 	 
	 	  ProductDto product = new ProductDto();
	 	
	 	  product.setId(rs.getInt(1));
	 	  product.setName(rs.getString(2));
	 	  product.setPrice(rs.getDouble(3));
	 	  product.setBrand(rs.getString(4));
	 	  product.setDiscount(rs.getDouble(5));
	 	  Blob imageBlob = rs.getBlob(6);
	 	  byte[] image = imageBlob.getBytes(1, (int)imageBlob.length());
	 	  product.setImage(image);
	 	  
	 	  con.close();
	 	  
	 	  return product;
	       
	}
	
	public List<ProductDto> getAll() throws ClassNotFoundException, SQLException
	{
		Connection con = getConnection();
	       
	    PreparedStatement pst = con.prepareStatement("select * from product");
	    
	    ResultSet rs = pst.executeQuery();
	    
	    List<ProductDto> products = new ArrayList<ProductDto>();
	    
	    while(rs.next())
	    {
		 	  ProductDto product = new ProductDto();

	    	  product.setId(rs.getInt(1));
		 	  product.setName(rs.getString(2));
		 	  product.setPrice(rs.getDouble(3));
		 	  product.setBrand(rs.getString(4));
		 	  product.setDiscount(rs.getDouble(5));
		 	  Blob imageBlob = rs.getBlob(6);
		 	  byte[] image = imageBlob.getBytes(1, (int)imageBlob.length());
		 	  product.setImage(image);
		 	 
		 	  products.add(product);
	    }
	    
	    return products;
	    
	}
	
	
	
	
	
	
	
}

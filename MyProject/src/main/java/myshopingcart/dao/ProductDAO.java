package myshopingcart.dao;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import myshopingcart.entity.Product;
import myshopingcart.model.PaginationResult;
import myshopingcart.model.ProductInfo;

@Repository
public interface ProductDAO {

	public Product findProduct(String code);

	public ProductInfo findProductInfo(String code);

	public void save(ProductInfo productInfo);

	public PaginationResult<ProductInfo> queryProducts(int page, int maxResult, int maxNavigationPage);

	public PaginationResult<ProductInfo> queryProducts(int page, int maxResult, int maxNavigationPage, String likeName);

}

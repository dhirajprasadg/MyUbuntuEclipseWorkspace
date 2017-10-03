package myshopingcart.dao.impl;

import java.io.IOException;
import java.util.Date;

import myshopingcart.dao.ProductDAO;
import myshopingcart.entity.Product;
import myshopingcart.model.PaginationResult;
import myshopingcart.model.ProductInfo;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/*http://www.journaldev.com/3481/hibernate-session-merge-vs-update-save-saveorupdate-persist-example
*/
/*
| Annotation | Meaning                                             |
+------------+-----------------------------------------------------+
| @Component | generic stereotype for any Spring-managed component |
| @Repository| stereotype for persistence layer                    |
| @Service   | stereotype for service layer                        |
| @Controller| stereotype for presentation layer (spring-mvc)      |*/


@Transactional
public class ProductDAOImpl implements ProductDAO {
	private static Logger log = Logger.getLogger(ProductDAOImpl.class);

	@Autowired
	private SessionFactory mySessionFactory;
	Session se = null;

	/*public void setMySessionFactory(SessionFactory mySessionFactory) {
		log.debug("session is setup");
		this.mySessionFactory = mySessionFactory;
	}*/

	@Override
	public Product findProduct(String code) {
		log.debug("findProduct");

		try {
			se = mySessionFactory.getCurrentSession();
		} catch (Exception e) {
			log.debug("current session cant be open");
			se = mySessionFactory.openSession();
		}

		Criteria cr = se.createCriteria(Product.class);
		cr.add(Restrictions.eq("code", code));
		Product pa = null;
		try {
			pa = (Product) cr.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// log.debug(" product returned : " + ((Product)
		// cr.uniqueResult()).toString());
		log.debug("Unique result : " + pa);
		return pa;

	}

	@Override
	public ProductInfo findProductInfo(String code) {
		return null;
	}

	@Override
	public void save(ProductInfo productInfo) {
		log.debug(" save called");
		String code = productInfo.getCode();
		log.debug(" save called : code : " + code);
		Product product = null;
		boolean isNew = false;
		if (code != null) {
			log.debug(" code is not null so calling find product");
			product = this.findProduct(code);
		}
		if (product == null) {
			log.debug("Product not found is db so creating new product");
			isNew = true;
			product = new Product();
			product.setCreateDate(new Date());
		}
		product.setCode(code);
		product.setName(productInfo.getName());
		product.setPrice(productInfo.getPrice());
		log.debug("Image productInfo.getFileData() : " + productInfo.getFileData());
		if (productInfo.getFileData() != null) {
			byte[] image = null;
			try {		
				image = productInfo.getFileData().getBytes();
				log.debug("Image Byte : " + image);
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (image != null && image.length > 0) {
				product.setImage(image);
			}
		}
		if (isNew) {
			try {
				se = this.mySessionFactory.getCurrentSession();
				se.persist(product);
				se.flush();
	
				/*
				 * se = mySessionFactory.getCurrentSession(); Transaction tx =
				 * se.beginTransaction(); se.saveOrUpdate(product); tx.commit();
				 */
			} catch (HibernateException e) {
				log.debug(" again opening new session");
				se = mySessionFactory.openSession();
				Transaction tx = se.beginTransaction();
				se.saveOrUpdate(product);
				tx.commit();
			}
			log.debug(" Session is open ------ " + se);
			// this.mySessionFactory.getCurrentSession().persist(product);
		}
		log.debug(" current session flush is called --- ");
		
		// this.mySessionFactory.getCurrentSession().flush();
	}

	 @Override
	 public PaginationResult<ProductInfo> queryProducts(int page, int maxResult, int maxNavigationPage,
	            String likeName) {
	        String sql = "Select new " + ProductInfo.class.getName() //
	                + "(p.code, p.name, p.price) " + " from "//
	                + Product.class.getName() + " p ";
	        if (likeName != null && likeName.length() > 0) {
	            sql += " Where lower(p.name) like :likeName ";
	        }
	        sql += " order by p.createDate desc ";
	        //
	        Session session = mySessionFactory.getCurrentSession();
	 
	        Query query = session.createQuery(sql);
	        if (likeName != null && likeName.length() > 0) {
	            query.setParameter("likeName", "%" + likeName.toLowerCase() + "%");
	        }
	        return new PaginationResult<ProductInfo>(query, page, maxResult, maxNavigationPage);
	    }
	 
	    @Override
	    public PaginationResult<ProductInfo> queryProducts(int page, int maxResult, int maxNavigationPage) {
	        return queryProducts(page, maxResult, maxNavigationPage, null);
	    }
	    
	
}

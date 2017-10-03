package myshopingcart.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.Map;

import myshopingcart.dao.ProductDAO;
import myshopingcart.dao.impl.ProductDAOImpl;
import myshopingcart.entity.Product;
import myshopingcart.model.PaginationResult;
import myshopingcart.model.ProductInfo;
import myshopingcart.validator.ProductInfoValidator;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Controller
@Transactional
//Need to use RedirectAttributes
@EnableWebMvc
public class ProductController {

	@Autowired
	public ProductDAO productDAO;

/*	@Autowired
	private ProductInfoValidator productInfoValidator;
*/
	public static Logger log = Logger.getLogger(ProductController.class);

	@InitBinder
	public void myInitBinder(WebDataBinder dataBinder) {
		Object target = dataBinder.getTarget();
		if (target == null) {
			return;
		}
		log.debug("Target=" + target);

		if (target.getClass() == ProductInfo.class) {
/*			dataBinder.setValidator(productInfoValidator);
*/			// For upload Image.
			dataBinder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
		}
	}

	@RequestMapping(value = "addproduct", method = RequestMethod.GET)
	public ModelAndView addProduct(@ModelAttribute("productForm") @Validated ProductInfo productinfo, ModelAndView mv) {
		log.debug("add Product called // ProductInfo to String " + productinfo.toString());
		productinfo.setName("Default Name ");
		mv.setViewName("product");
		return mv;
	}

	@RequestMapping(value = "addProducts", method = RequestMethod.POST)
	@Transactional(propagation = Propagation.NEVER)
	public @ResponseBody
	ProductInfo addProducts(@ModelAttribute("productForm") ProductInfo productInfo, BindingResult result) {
		log.debug(" product detail " + productInfo.toString());

		try {
			productDAO.save(productInfo);
		} catch (Exception e) {
			String message = e.getMessage();
			log.debug("Error in saving : " + message);
			e.printStackTrace();
		}
		productInfo.setFileData(null);
		return productInfo;

	}
	
	

	 @RequestMapping({ "/productList" })
	 public String listProductHandler(Model model,
	         @RequestParam(value = "name", defaultValue = "") String likeName,
	         @RequestParam(value = "page", defaultValue = "1") int page) {
	     final int maxResult = 5;
	     final int maxNavigationPage = 10;

	     PaginationResult<ProductInfo> result = productDAO.queryProducts(page, maxResult, maxNavigationPage, likeName);

	     model.addAttribute("paginationProducts", result);
	     return "productList";
	 }

	
	
	
	
	
	
	
	
	
	
}
/*	
	@RequestMapping(value = "addProductsgetimage", method = RequestMethod.POST)
	@Transactional(propagation = Propagation.NEVER)
	public @ResponseBody
	ResponseEntity<byte[]> addProductsgetimage(@ModelAttribute("productFormimage") ProductInfo productInfo) {
		log.debug(" product detail " + productInfo.toString());
		
		File file = null;
		String IMAGE_TMP_DIR = "E:/eclipse/workspace/Junk";
		ResponseEntity<byte[]> response =null;
		  try {
			  
		    final MultiValueMap<String, Object> requestParts = new LinkedMultiValueMap<>();
		    
		    final String tmpImageFileName = IMAGE_TMP_DIR + productInfo.getFileData().getOriginalFilename();
		    
		    log.debug(" file location " + tmpImageFileName);
		    
		    file = new File(tmpImageFileName);
		    
		    productInfo.getFileData().transferTo(file);
		    
		    requestParts.add("file", new FileSystemResource(tmpImageFileName));

		    HttpHeaders headers = new HttpHeaders();
		    headers.set("Content-Type", "multipart/form-data"); // Sending it like the client-form sends it
		    RestTemplate restTemplate = new RestTemplate();
		  
		    String url = "http://localhost:8080/MyProject/addProductsgetimage.sp";
		   
		    
		     response = restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<>(requestParts, headers),byte[].class);

		    return new ResponseEntity<>(response.getBody(), response.getStatusCode());
		  } catch (Exception ex) {
			  log.debug("Exception happened while sending Image file");
		    try {
				return new ResponseEntity<>((ex.getMessage()).getBytes("UTF-8"),HttpStatus.INTERNAL_SERVER_ERROR);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		  } finally {
		    if (file != null && file.exists()) {
		    	log.debug("We can delete the file");
		    	//     file.delete();
		    }
		  }
		return new ResponseEntity<>(response.getBody(), response.getStatusCode());
		
		
		

	}
	
*/
	

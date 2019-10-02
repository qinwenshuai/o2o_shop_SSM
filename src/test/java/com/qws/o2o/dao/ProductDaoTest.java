package com.qws.o2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import com.qws.o2o.BaseTest;
import com.qws.o2o.entity.Product;
import com.qws.o2o.entity.ProductCategory;
import com.qws.o2o.entity.ProductImg;
import com.qws.o2o.entity.Shop;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductDaoTest extends BaseTest {

	@Autowired
	private ProductDao productDao;
	@Autowired
	private ProductImgDao productImgDao;
	@Test
	//测试数据不会影响数据库，即测试数据不进入数据库。
	//@Ignore
	public void testAInsertProduct() throws Exception {
		Shop shop1 = new Shop();
	//查看tb_product_category，shop_id和product_category_id的值
		shop1.setShopId(28L);
		ProductCategory pc1 = new ProductCategory();
		pc1.setProductCategoryId(6L);
		// 初始化三个商品实例并添加进shopId为1的店铺里，
		// 同时商品类别Id也为1
		Product product1 = new Product();
		product1.setProductName("测试1");
		product1.setProductDesc("测试Desc1");
		product1.setImgAddr("test1");
		product1.setPriority(1);
		product1.setEnableStatus(1);
		product1.setCreateTime(new Date());
		product1.setLastEditTime(new Date());
		product1.setShop(shop1);
		product1.setProductCategory(pc1);
		Product product2 = new Product();
		product2.setProductName("测试2");
		product2.setProductDesc("测试Desc2");
		product2.setImgAddr("test2");
		product2.setPriority(2);
		product2.setEnableStatus(0);
		product2.setCreateTime(new Date());
		product2.setLastEditTime(new Date());
		product2.setShop(shop1);
		product2.setProductCategory(pc1);
		Product product3 = new Product();
		product3.setProductName("test3");
		product3.setProductDesc("测试Desc3");
		product3.setImgAddr("test3");
		product3.setPriority(3);
		product3.setEnableStatus(1);
		product3.setCreateTime(new Date());
		product3.setLastEditTime(new Date());
		product3.setShop(shop1);
		product3.setProductCategory(pc1);
		// 判断添加是否成功
		int effectedNum = productDao.insertProduct(product1);
		assertEquals(1, effectedNum);
		effectedNum = productDao.insertProduct(product2);
		assertEquals(1, effectedNum);
		effectedNum = productDao.insertProduct(product3);
		assertEquals(1, effectedNum);
	}

	@Test
	public void testBQueryProductList() throws Exception {
		Product productCondition = new Product();
		// 分页查询，预期返回三条结果
		List<Product> productList = productDao.queryProductList(productCondition, 0, 3);
		assertEquals(3, productList.size());
		// 查询商品总数
		int count = productDao.queryProductCount(productCondition);
		assertEquals(15, count);
		// 使用商品名称模糊查询，预期返回两条结果
		productCondition.setProductName("测试");
		productList = productDao.queryProductList(productCondition, 0, 3);
		assertEquals(5, productList.size());
		count = productDao.queryProductCount(productCondition);
		assertEquals(5, count);
	}

	@Test
	public void testCQueryProductByProductId() throws Exception {
		long productId = 12L;
		// 初始化两个商品详情图实例作为productId为1的商品下的详情图片
		// 批量插入到商品详情图表中
		ProductImg productImg1 = new ProductImg();
		productImg1.setImgAddr("图片1");
		productImg1.setImgDesc("测试图片1");
		productImg1.setPriority(1);
		productImg1.setCreateTime(new Date());
		productImg1.setProductId(productId);
		ProductImg productImg2 = new ProductImg();
		productImg2.setImgAddr("图片2");
		productImg2.setImgDesc("测试图片2");
		productImg2.setPriority(1);
		productImg2.setCreateTime(new Date());
		productImg2.setProductId(productId);
		List<ProductImg> productImgList = new ArrayList<ProductImg>();
		productImgList.add(productImg1);
		productImgList.add(productImg2);
		int effectedNum = productImgDao.batchInsertProductImg(productImgList);
		assertEquals(2, effectedNum);
		// 查询productId为1的商品信息并校验返回的详情图实例列表size是否为tb_product_img中product_id=12的记录数
		Product product = productDao.queryProductById(productId);
		assertEquals(2, product.getProductImgList().size());
		// 删除新增的这两个商品详情图实例
		effectedNum = productImgDao.deleteProductImgByProductId(productId);
		assertEquals(2, effectedNum);
	}

	@Test
	public void testDUpdateProduct() throws Exception {
		Product product = new Product();
		ProductCategory pc = new ProductCategory();
		Shop shop = new Shop();
		shop.setShopId(28L);
		pc.setProductCategoryId(5L);
		product.setProductId(12L);
		product.setShop(shop);
		product.setProductName("第二个产品");
		product.setProductCategory(pc);
		// 修改productId为1的商品的名称
		// 以及商品类别并校验影响的行数是否为1
		int effectedNum = productDao.updateProduct(product);
		assertEquals(1, effectedNum);
	}

	@Test
	public void testEUpdateProductCategoryToNull() {
	// 将productCategoryId为2的商品类别下面的商品的商品类别置为空
		int effectedNum = productDao.updateProductCategoryToNull(2L);
		assertEquals(1, effectedNum);
	}

	@Test
	@Ignore
	public void testFDeleteShopAuthMap() throws Exception {
		// 清除掉insert方法添加的商品
		Product productCondition = new Product();
		ProductCategory pc = new ProductCategory();
		pc.setProductCategoryId(1L);
		productCondition.setProductCategory(pc);
   // 通过输入productCategoryId为1去商品表中查出新增的三条测试数据
		List<Product> productList = productDao.queryProductList(productCondition, 0, 3);
		assertEquals(3, productList.size());
		// 循环删除这三条数据
		for (Product p : productList) {
			int effectedNum = productDao.deleteProduct(p.getProductId(), 1);
			assertEquals(1, effectedNum);
		}
	}
}


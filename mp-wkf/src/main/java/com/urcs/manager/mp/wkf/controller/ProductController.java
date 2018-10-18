package com.urcs.manager.mp.wkf.controller;

import com.feinno.rpc.RpcEndpointFactory;
import com.feinno.rpc.client.RpcProxyFactory;
import com.urcs.data.service.common.base.ParameterBean;
import com.urcs.data.service.wkf.api.ProductService;
import com.urcs.data.service.wkf.api.entity.ListProductBean;
import com.urcs.data.service.wkf.api.entity.ProductBean;
import com.urcs.manager.mp.common.config.Constant;
import com.urcs.manager.mp.common.controller.BaseController;
import com.urcs.manager.mp.common.utils.PageUtils;
import com.urcs.manager.mp.common.utils.Query;
import com.urcs.manager.mp.common.utils.R;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 文章内容
 *
 */
@Controller
@RequestMapping("/urcs/wkf/product")
public class ProductController extends BaseController {
	private  ProductService productService;


	public void init(){
		if (productService == null){
			synchronized (this){
				if (productService == null){
					productService = RpcProxyFactory.getTransparentProxy("data.ProductService",
							ProductService.class, () -> RpcEndpointFactory.parse("tcp://10.10.12.75:7016;protocol=rpc"));
				}
			}

		}
	}
	@GetMapping()
	@RequiresPermissions("urcs:wkf:product")
	String product() {
		return "/urcs/wkf/product/list";
	}

	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("urcs:wkf:product")
	public PageUtils list(@RequestParam Map<String, String> params) {
		init();
		//展示
		ParameterBean parameterBean = new ParameterBean();
		parameterBean.setMap(params);
		params.put("namespace", "1111");

		ListProductBean listProductBean = productService.list(parameterBean);
		int total = listProductBean.getProductBeanList().size();
		PageUtils pageUtils = new PageUtils(listProductBean.getProductBeanList(), total);
		return pageUtils;
	}

	@GetMapping("/add")
	@RequiresPermissions("urcs:wkf:product:add")
	String add() {
		return "urcs/wkf/product/add";
	}

	@GetMapping("/edit/{pid}")
	@RequiresPermissions("urcs:wkf:product:edit")
	String edit(@PathVariable("pid") String pid, Model model) {
		init();
		//修改
		ProductBean productBean = new ProductBean();
		productBean.setProductId(pid);
		productBean	= productService.get(productBean);
		model.addAttribute("goodsBean", productBean);
		return "urcs/wkf/goods/edit";
	}

	/**
	 * 保存
	 */
	@ResponseBody
	@RequiresPermissions("urcs:wkf:product:add")
	@PostMapping("/save")
	public R save(ProductBean productBean) {
		init();

		//TODO
		productBean.setCompanyId("1111");
		productBean.setProductId(null);
		productBean.setProductCreateTime(new Date().toString());
		productBean	= productService.save(productBean);
		if (productBean != null) {
			return R.ok().put("productId", productBean.getProductId());
		}
		return R.error();
	}

	/**
	 * 修改
	 */
	@RequiresPermissions("urcs:wkf:product:edit")
	@ResponseBody
	@RequestMapping("/update")
	public R update(ProductBean productBean) {
		init();
		productBean.setCompanyId("1111");
		productBean.setProductCreateTime(new Date().toString());
		productBean	= productService.update(productBean);
		if (productBean != null) {
			return R.ok().put("productId", productBean.getProductId());
		}
		return R.ok();
	}

	/**
	 * 删除
	 */
	@RequiresPermissions("urcs:wkf:product:remove")
	@PostMapping("/remove")
	@ResponseBody
	public R remove(String productId) {
		init();
		//修改
		ProductBean productBean = new ProductBean();
		productBean.setCompanyId("1111");
		productBean.setProductId(productId);
		productBean	= productService.remove(productBean);
		if (productBean != null) {
			return R.ok();
		}
		return R.error();
	}

	/**
	 * 删除
	 */
	@RequiresPermissions("urcs:wkf:product:batchRemove")
	@PostMapping("/batchRemove")
	@ResponseBody
	public R remove(@RequestParam("productIds[]") String[] productIds) {
		init();
		ListProductBean listProductBean = new ListProductBean();
		for (String productId:productIds) {
			ProductBean productBean = new ProductBean();
			productBean.setCompanyId("1111");
			productBean.setProductId(productId);
			listProductBean.getProductBeanList().add(productBean);
		}
		productService.batchRemove(listProductBean);
		return R.ok();
	}
}

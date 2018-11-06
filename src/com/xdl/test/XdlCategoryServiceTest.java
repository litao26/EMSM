package com.xdl.test;

import java.util.List;

import com.xdl.bean.XdlCategory;
import com.xdl.bean.XdlNews;
import com.xdl.service.XdlCategoryService;
import com.xdl.service.XdlNewsService;

public class XdlCategoryServiceTest {

	public static void main(String[] args) {
		/*List<XdlCategory>  datas = new XdlCategoryService().subCategories(0);
		System.out.println(datas);*/
		List<XdlNews> datas = new XdlNewsService().subNews("新闻");
		System.out.println(datas);

	}

}

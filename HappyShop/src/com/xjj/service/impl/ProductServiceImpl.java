package com.xjj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjj.dao.ProductDao;
import com.xjj.entity.Product;
import com.xjj.service.ProductService;
import com.xjj.util.PageBean;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDao;

	@Override
	public List<Product> findHot() {
		return productDao.findHot();
	}

	@Override
	public List<Product> findNew() {
		return productDao.findNew();
	}

	@Override
	public Product findByPid(Integer pid) {
		return productDao.findByPid(pid);
	}

	@Override
	public PageBean<Product> findByPageCid(Integer cid,Integer page) {
		PageBean<Product> pageBean = new PageBean<Product>();
		//���õ�ǰҳ��
		pageBean.setPage(page);
		//����ÿҳ��ʾ��
		int pageSize = 10;
		pageBean.setPageSize(pageSize);
		//�����ܼ�¼��
		int totalCount = 0;
		totalCount = productDao.findCountCid(cid);
		//System.out.println("�ܼ�¼����"+totalCount);
		pageBean.setTotalCount(totalCount);
		//������ҳ��
		int totalPage = 0;
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		}else {
			totalPage = totalCount / pageSize + 1;
		}
		System.out.println("��ҳ����"+totalPage);
		pageBean.setTotalPage(totalPage);
		//ÿҳ��ʾ�����ݣ����Ŀ�ʼ
		int begin = (page-1)*pageSize;
		List<Product> list = productDao.findByPageCid(cid, begin, pageSize);
		System.out.println("��ҳ��ʾ��list��"+list);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public PageBean<Product> findByPageCsid(Integer csid, Integer page) {
		PageBean<Product> pageBean = new PageBean<Product>();
		System.out.println(page);
		//���õ�ǰҳ��
		pageBean.setPage(page);
		//����ÿҳ��ʾ��
		int pageSize = 10;
		pageBean.setPageSize(pageSize);
		//�����ܼ�¼��
		int totalCount = 0;
		totalCount = productDao.findCountCsid(csid);
		//System.out.println("����������ܼ�¼����"+totalCount);
		pageBean.setTotalCount(totalCount);
		//������ҳ��
		int totalPage = 0;
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		}else {
			totalPage = totalCount / pageSize + 1;
		}
		//System.out.println("��ҳ����"+totalPage);
		pageBean.setTotalPage(totalPage);
		//ÿҳ��ʾ�����ݣ����Ŀ�ʼ
		int begin = (page-1)*pageSize;
		List<Product> list = productDao.findByPageCsid(csid, begin, pageSize);
		//System.out.println("������ҳ��ʾ��list��"+list);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public int insertProduct(Product product) {
		return productDao.insertProduct(product);
	}

	@Override
	public int deleteProduct(Integer pid) {
		return productDao.deleteProduct(pid);
	}
	
	@Override
	public int updateProduct(Product product) {
		return productDao.updateProduct(product);
	}

	@Override
	public PageBean<Product> findByPage(Integer page) {
		PageBean<Product> pageBean = new PageBean<Product>();
		pageBean.setPage(page);
		int pageSize = 10;
		pageBean.setPageSize(pageSize);
		int totalCount = productDao.findCount();
		pageBean.setTotalCount(totalCount);
		int totalPage = 0;
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		}else {
			totalPage = totalCount / pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		int begin = (page - 1) * pageSize;
		List<Product> list = productDao.findByPage(begin, pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public List<Product> findAll() {
		return productDao.findAll();
	}

}

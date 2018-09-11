package com.xjj.controller.order;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xjj.entity.Cart;
import com.xjj.entity.CartItem;
import com.xjj.entity.Order;
import com.xjj.entity.OrderItem;
import com.xjj.entity.User;
import com.xjj.service.OrderItemService;
import com.xjj.service.OrderService;
import com.xjj.util.PageBean;
import com.xjj.util.PaymentUtil;

@Controller
public class OrderController {
	
	private Order order = new Order();
	@Autowired
	private OrderService orderService;
	@Autowired
	private OrderItemService orderItemSevice;
	
	@RequestMapping("/saveOrder")
	public String saveOrder(HttpSession session) {
		Cart cart = (Cart) session.getAttribute("cart");
		if (cart == null) {
			System.out.println("���ع��ﳵҳ��");
			return "cart";
		}
		// ���ö��������Ŀͻ�:
		User existUser = (User) session.getAttribute("user");
		if (existUser == null) {
			System.out.println("���ص�¼ҳ��");
			return "login";
		}
		//���ø����ܷ���
		order.setTotal(cart.getTotal());
		//����״̬
		order.setState(1);//0:�Ѹ��1��δ����
		//����ʱ��
		order.setOrdertime(new Date());
		//��ʾ�û���Ϣ
		order.setUser(existUser);
		order.setUid(existUser.getUid());
		//���ɶ���
		orderService.saveOrder(order);
		//�������
		for (CartItem cartItem : cart.getCartItems()) {
			OrderItem orderItem = new OrderItem();
			orderItem.setCount(cartItem.getCount());
			orderItem.setSubtotal(cartItem.getSubtotal());
			orderItem.setPid(cartItem.getProduct().getPid());
			orderItem.setProduct(cartItem.getProduct());
			orderItem.setOid(order.getOid());
			//���ɶ���������
			orderItemSevice.saveOrderItem(orderItem);
			order.getOrderItems().add(orderItem);
		}
		// ��order���󱣴浽session���У�Ϊ���ܹ��ڶ���ҳ����Զ�����Ϣ
		session.setAttribute("order", order);
		//��չ��ﳵ
		cart.clearCart();
		return "order";
	}
	//�����û�id��ѯ����
	@RequestMapping("/findByUid")
	public String findByUid(Integer uid,Integer page,HttpSession session) {
		PageBean<Order> pageBean = orderService.findPageByUid(uid, page);
		session.setAttribute("pageBean", pageBean);
		return "orderList";
	}
	//���ݶ���id��ѯ����
	@RequestMapping("/findByOid")
	public String findByOid(Integer oid,HttpSession session) {
		User user = (User) session.getAttribute("user");
		order = orderService.findByOid(oid);
		//�����û������û��ܹ���ѯ�ҵĶ���֮���ܲ�ѯ�û���Ϣ
		order.setUser(user);
		session.setAttribute("order", order);
		System.out.println("����id��ѯ���Ķ�����"+order);
		return "order";
	}
	//�޸Ķ�����״̬
	public void updateState() {
		Order currOrder = orderService.findByOid(order.getOid());
		currOrder.setState(4);
		orderService.update(currOrder);
	}
	// Ϊ��������: ����֧��ͨ������ pd_FrpId CCB-WAP
	@RequestMapping("/payOrder")
	public void payOrder(String pd_FrpId,HttpServletResponse response) throws IOException {
		//�޸�����
		Order currOrder = orderService.findByOid(order.getOid());
		currOrder.setAddr(order.getUser().getAddr());
		currOrder.setName(order.getUser().getName());
		currOrder.setPhone(order.getUser().getPhone());
		//�޸Ķ���
		orderService.update(currOrder);
		//��ɸ���
		String p0_Cmd = "Buy"; // ҵ������
		String p1_MerId = "10001126856";// �̻����:
		String p2_Order = order.getOid().toString();// �������:
		String p3_Amt = "0.01"; // ������:
		String p4_Cur = "CNY"; // ���ױ���:
		String p5_Pid = ""; // ��Ʒ����:
		String p6_Pcat = ""; // ��Ʒ����:
		String p7_Pdesc = ""; // ��Ʒ����:
		String p8_Url = "http://localhost:8080/HappyShop/callBack"; // �̻�����֧���ɹ����ݵĵ�ַ:
		String p9_SAF = ""; // �ͻ���ַ:
		String pa_MP = ""; // �̻���չ��Ϣ:
		String pr_NeedResponse = "1"; // Ӧ�����:
		String keyValue = "69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl"; // ��Կ
		String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt,
				p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP,
				pd_FrpId, pr_NeedResponse, keyValue); // hmac
		//���׸�����������
		StringBuffer sb = new StringBuffer("https:/www.yeepay.com/app-merchant-proxy/node?");
		sb.append("p0_Cmd=").append(p0_Cmd).append("&");
		sb.append("p1_MerId=").append(p1_MerId).append("&");
		sb.append("p2_Order=").append(p2_Order).append("&");
		sb.append("p3_Amt=").append(p3_Amt).append("&");
		sb.append("p4_Cur=").append(p4_Cur).append("&");
		sb.append("p5_Pid=").append(p5_Pid).append("&");
		sb.append("p6_Pcat=").append(p6_Pcat).append("&");
		sb.append("p7_Pdesc=").append(p7_Pdesc).append("&");
		sb.append("p8_Url=").append(p8_Url).append("&");
		sb.append("p9_SAF=").append(p9_SAF).append("&");
		sb.append("pa_MP=").append(pa_MP).append("&");
		sb.append("pd_FrpId=").append(pd_FrpId).append("&");
		sb.append("pr_NeedResponse=").append(pr_NeedResponse).append("&");
		sb.append("hmac=").append(hmac);
		//�ض����׸���
		response.sendRedirect(sb.toString());
	}
	
	//����ɹ���ת��·��
	@RequestMapping("callBack")
	public String callBack(String r3_Amt,String r6_Order,Model model) {
		Order currOrder = orderService.findByOid(Integer.parseInt(r6_Order));
		currOrder.setState(2);
		orderService.update(currOrder);
		model.addAttribute("info", "֧���ɹ���������ţ�"+r6_Order+"�����"+currOrder.getTotal());
		return "msg";
	}
}

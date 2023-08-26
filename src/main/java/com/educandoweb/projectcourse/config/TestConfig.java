package com.educandoweb.projectcourse.config;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.educandoweb.projectcourse.entities.*;
import com.educandoweb.projectcourse.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private OrderItemRepository orderItemRepository;

	@Override
	public void run(String... args) throws Exception {

		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");

		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

		List<Product> list3 = new ArrayList<>();
		list3.add(p1);
		list3.add(p2);
		list3.add(p3);
		list3.add(p4);
		list3.add(p5);


		List<Category> list2 = new ArrayList<>();
		list2.add(cat1);
		list2.add(cat2);
		list2.add(cat3);

		categoryRepository.saveAll(list2);
		productRepository.saveAll(list3);

		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);

		List<Product> listC = new ArrayList<>();
		listC.add(p1);
		listC.add(p2);
		listC.add(p3);
		listC.add(p4);
		listC.add(p5);

		productRepository.saveAll(listC);



		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);


		List<User> list = new ArrayList<>();
		list.add(u1);
		list.add(u2);

		List<Order> list1 = new ArrayList<>();
		list1.add(o1);
		list1.add(o2);
		list1.add(o3);

		userRepository.saveAll(list);
		orderRepository.saveAll(list1);

		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());

		List<OrderItem> listOi = new ArrayList<>();
		listOi.add(oi1);
		listOi.add(oi2);
		listOi.add(oi3);
		listOi.add(oi4);

		orderItemRepository.saveAll(listOi);

		Payment pay1 = new Payment(null, Instant.parse("2019-06-20T21:53:07Z"), o1);
		o1.setPayment(pay1);

		orderRepository.save(o1);
		
	}
	
	
}

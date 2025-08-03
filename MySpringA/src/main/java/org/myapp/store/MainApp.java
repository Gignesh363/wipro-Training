package org.myapp.store;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Item item = context.getBean(Item.class);

        // Set values manually (or could be hardcoded/defaults)
        item.setId(1);
        item.setName("Laptop");
        item.setPrice(75000);

        item.display();
    }
}

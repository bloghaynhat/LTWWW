package me.minhduc.ontapthuoc;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import me.minhduc.ontapthuoc.utils.JPAUtil;

@WebListener
public class Application implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        JPAUtil.init();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        JPAUtil.close();
    }
}

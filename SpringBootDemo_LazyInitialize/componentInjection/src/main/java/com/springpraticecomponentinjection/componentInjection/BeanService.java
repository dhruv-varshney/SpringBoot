package com.springpraticecomponentinjection.componentInjection;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class BeanService {
    private final BadmintonCoach eagerBean;
    private final CricketCoach lazyBean;

    public BeanService(BadmintonCoach eagerBean, @Lazy CricketCoach lazyBean) {
        this.eagerBean = eagerBean;
        this.lazyBean = lazyBean;
        System.out.println("BeanService initialized");
    }

    public void execute() {
        System.out.println("Executing service methods...");
        lazyBean.doSomething();
        eagerBean.doSomething();
    }
}


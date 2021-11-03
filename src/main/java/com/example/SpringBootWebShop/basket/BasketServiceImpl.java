package com.example.SpringBootWebShop.basket;

import com.example.SpringBootWebShop.appuser.AppUser;
import com.example.SpringBootWebShop.appuser.AppUserService;
import com.example.SpringBootWebShop.appuser.AppUserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class BasketServiceImpl implements BasketService {
    private final BasketRepository basketRepository;
    private final AppUserServiceImpl appUserService;

    public BasketServiceImpl(BasketRepository basketRepository, @Lazy AppUserServiceImpl appUserService) {
        this.basketRepository = basketRepository;
        this.appUserService = appUserService;
    }

    @Override
    public Basket getById(Long id) {
        return basketRepository.getById(id);
    }

    @Override
    public Basket createBasket(Long user_id) {
        return null;
    }


}

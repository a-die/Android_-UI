package com.hnucm.c201901020241;

import java.util.List;

public class Buy {

    public List<ShoplistDTO> shoplist;

    public static class ShoplistDTO {
        public String shop_name;
        public String title;
        public String option;
        public String price;
        public String other;
        public String num;
        public String image;
    }
}

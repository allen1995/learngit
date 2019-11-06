package com.allen.dayup.thinkinjava.chap10;

/**
 * @Auther: 20190598
 * @Date: 2019/10/28 16:07
 * @Description:
 */
public class Parcel10 {

    public Destination destination(String dest, float price){

        return new Destination(){
            private float cost;

            {
                cost = price;
                if( cost > 10 ){
                    System.out.println("Over budget....");
                }
            }

            private String label = dest;
            public String readLabel(){
                return label;
            }
        };
    }

    public static void main(String[] args) {
        Parcel10 parcel10 = new Parcel10();
        Destination destination = parcel10.destination("Tasmania",12.5f);
        System.out.println(destination.readLabel());
    }

    class Destination {
        private String label;

        public Destination(String lavel) {
            this.label = lavel;
        }

        public Destination() {
        }

        public String readLabel(){
            return label;
        };
    }
}


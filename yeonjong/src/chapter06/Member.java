package chapter06;


 public class Member {
     private final String userId;
     private final String name;
     private final String address;
     private final int phoneNumber;
     private final int height;

     public static class Builder {
        private String userId;
        private String name;
        private String address = null;
        private int phoneNumber = 0;
        private int height = 0;

        public Builder(String userId, String name) {
            this.userId = userId;
            this.name = name;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder phoneNumber(int phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder height(int height) {
            this.height = height;
            return this;
        }

        public Member build() throws IllegalStateException {
            return new Member(this);
        }
     }

     private Member(Builder builder) {
         userId = builder.userId;
         name = builder.name;
         address = builder.address;
         phoneNumber = builder.phoneNumber;
         height = builder.height;
     }

     public static void main(String[] args) {
         Member yeonjong = new Builder("yjshin", "yj")
                            .address("Seoul")
                            .height(164)
                            .build();
     }
 }


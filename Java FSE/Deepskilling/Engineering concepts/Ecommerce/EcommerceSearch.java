

public class EcommerceSearch {

   
    static class Product {
        int productId;
        String productName;
        String category;

        Product(int id, String name, String category) {
            this.productId = id;
            this.productName = name;
            this.category = category;
        }

        @Override
        public String toString() {
            return productId + " - " + productName + " (" + category + ")";
        }
    }

 
    public static Product linearSearch(Product[] products, String target) {
        for (Product product : products) {
            if (product.productName.equalsIgnoreCase(target)) {
                return product;
            }
        }
        return null;
    }

   
    public static Product binarySearch(Product[] products, String target) {
        int left = 0, right = products.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = products[mid].productName.compareToIgnoreCase(target);
            if (cmp == 0) return products[mid];
            else if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return null;
    }

 
    public static void sortProductsByName(Product[] products) {
        java.util.Arrays.sort(products, (a, b) -> a.productName.compareToIgnoreCase(b.productName));
    }

    // Main method for testing
    public static void main(String[] args) {

        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Shoes", "Footwear"),
            new Product(103, "Watch", "Accessories"),
            new Product(104, "Mobile", "Electronics"),
            new Product(105, "Backpack", "Bags")
        };

      
        System.out.println("Linear Search for 'Watch':");
        Product foundLinear = linearSearch(products, "Watch");
        System.out.println(foundLinear != null ? foundLinear : "Product not found.");

       
        sortProductsByName(products);
        System.out.println("\n Binary Search for 'Watch':");
        Product foundBinary = binarySearch(products, "Watch");
        System.out.println(foundBinary != null ? foundBinary : "Product not found.");
    }
}

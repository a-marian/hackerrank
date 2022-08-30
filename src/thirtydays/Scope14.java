package thirtydays;

    class Difference {
        private int[] elements;
        public int maximumDifference;

        Difference(int[] elements){
            this.elements = elements;
        }

        public void setElements(int[] elements){
            this.elements = elements;
        }

        public  int[] getElements(){
            return elements;
        }

        // Add your code here
        public  void computeDifference(){

            int [] arr = this.elements;
            int loop = 0;
            while (loop < arr.length){
                int value = arr[loop];
                for (int i = loop; i < arr.length-1; i++) {
                    int absValue = Math.abs(value- arr[i+1]);
                    maximumDifference = Math.max(absValue, maximumDifference);
                }
                loop++;
            }

        }

    }

public class Scope14 {
    public static void main(String[] args) {
         int [] a = {8, 19, 3, 2, 7};
        Difference difference = new Difference(a);

        difference.computeDifference();

        System.out.print(difference.maximumDifference);
    }
}

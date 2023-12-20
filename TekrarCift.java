import java.util.Arrays;
import java.util.Scanner;
public class TekrarCift {

    public static boolean isDuplicate(int[] array, int value ){
        for(int i= 0; i<array.length;i++){
            if(array[i]== value){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int arrayLength;

        System.out.print("Array uzunluğunu girin:  ");
        arrayLength = input.nextInt();

        int [] myArray = new int[arrayLength];

        // myArray i kullanıcıdan aldığımız değerlerle oluşturuyoruz.

        for(int i = 0; i < arrayLength;i++){
            System.out.print("Arrayın "+ (i+1) +". elemanını girin:  ");
            myArray[i] = input.nextInt();
        }

        int [] duplicateArray = new int[arrayLength];

        int count = 0;
        for(int i = 0; i<arrayLength;i++){
            for(int j = i+1 ; j<arrayLength;j++ ){

                // hep myArray[i] nin çift olup olmadığını hem duplicate olup olmadığını,
                // öyleyse duplicate arrayin içinde olup olmadığını kontrol ediyoruz

                if(myArray[i] % 2 == 0 && myArray[i] == myArray[j] && isDuplicate(duplicateArray, myArray[i])){
                    duplicateArray[count++] = myArray[i];
                }
            }
        }

        // result array içinde tutuyoruz ve copyof metoduyla sadece 0 ile count değişkeninin değeri kadar bir
        // array i tutuyoruz böylece 0 0 0 lardan kurtulduk
        
        int [] resultArray = new int[count];
        resultArray = Arrays.copyOf(duplicateArray,count);
        System.out.println(Arrays.toString(myArray));
        System.out.println(Arrays.toString(resultArray));
    }
}

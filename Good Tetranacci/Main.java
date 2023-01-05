import java.io.*;

public class Main {

  static long[] result = new long[6];
  static long[] elapsed = new long[6];

  // recording tetra numbers and times to executing them
  public static void tetraExperiment() {

    for (int i = 0; i<= 5; i++){
    long startTime = System.nanoTime( ); // record the starting time
    long [] tempResult = tetranacciGood(i*5);
    long endTime = System.nanoTime(); // record the ending time
    result[i] = tempResult[3];
    elapsed[i] = endTime - startTime; // compute the elapsed time

    }

  }

  // Good tetranacci recursive code
  // return array containing four tetranacci numbers:
  // T(n-3), T(n-2), T(n-1), T(n)
  public static long[] tetranacciGood(int n) {
    if (n <= 4) {
      long[] answer = {0, 0, 0, 1};
      return answer;
    } else {
      long[] temp = tetranacciGood(n - 1);
      long[] answer = {
        temp[1],
        temp[2],
        temp[3],
        temp[0] + temp[1] + temp[2] + temp[3]
      };
      return answer;
    }
  }
    

  public static void main(String[] args) {
  /*   long startTime = System.nanoTime( ); // record the starting time

    long[] result = tetranacciGood(25);

    long endTime = System.nanoTime(); // record the ending time
    long elapsed = endTime - startTime; // compute the elapsed time
*/
    tetraExperiment();
  //  System.out.println("Number is: " + result[5]);
  //  System.out.println("elapsed time is: " + elapsed[5]);



    // writing the results to a file
    try {
      
      BufferedWriter writer = new BufferedWriter(new FileWriter
      ("C:\\Users\\alals\\Desktop\\Good Tetranacci\\tetraGood_output.txt"));
      
      writer.write("index:\t\t\t\t4\t\t5\t\t10\t\t20\t\t25\t\t30\n");
      writer.write("Tetranacci numbers:");

      for (long num1 : result) {
        writer.write("\t\t" + num1);
      }

      writer.write("\n");
      writer.write("Time elapsed(ns):");

      for (long num2 : elapsed) {
        writer.write("\t\t" + num2);
      }

    //  writer.close();
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}

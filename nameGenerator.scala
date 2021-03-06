import java.io._

object nameGenerator {
  def main(args: Array[String]): Unit = {
    val maj = ('A' to 'Z').toList
    val min = ('a' to 'z').toList
    val vowel_maj = List('A', 'E', 'I', 'O', 'U', 'Y')
    val vowel_min = List('a', 'e', 'i', 'o', 'u', 'y')
    val conso_maj = maj.filterNot(vowel_maj.contains(_))
    val conso_min = min.filterNot(vowel_min.contains(_))

    val Vcv = vowel_maj.map { V => conso_min.map { c => vowel_min.map { v => V.toString()+c.toString()+v.toString() } } }.flatten.flatten
    val Cvc = conso_maj.map { C => vowel_min.map { v => conso_min.map { c => C.toString()+v.toString()+c.toString() } } }.flatten.flatten
    
    val pw = new PrintWriter(new File("generatedNames.txt" ))
    pw.write("Vcv\n_______\n")
    Vcv.map { Vcv => pw.write(Vcv+"\n") }
    pw.write("\nCvc\n_______\n")
    Cvc.map { Cvc => pw.write(Cvc+"\n") }
    pw.close
    println(Vcv.size+" "+Cvc.size)
  } 
}

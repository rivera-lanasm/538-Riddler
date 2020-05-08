
import cc.redberry.rings
import rings.poly.PolynomialMethods._
import rings.scaladsl._
import syntax._


/**

https://www.semion.io/doc/on-a-uniformly-random-chord-diagram-and-its-intersection-graph



Tn(x) --> generating function yielding polynomial with coefficients, Tnk --> number of ways of choosing n pairs of points among 2n
general points suchh that there are k intersections 
 
term 1: an+j, n-j  = (2j+1)/(n+j+1) * ( 2n n+ j)

(-1)^j * ballot

1) array for exponents
2) array for coefficients 

 */

package analytic {

object RiordanGeneratingFunction{

    def combinations(n: Int, k: Int): Int = {

        if (k == 0 || k == n) {
        1 } else {
        combinations(n - 1, k - 1) + combinations(n - 1, k)
            }
        }


    def ballot_num(n: Int, j: Int): Int = {

        val t1: Double = (2.0*j +1.0)/(n + j + 1.0)
        
        val t2: Double = combinations(2*n, n+j)
        (t1*t2).toInt
        }

    def RiordanPolynomial(order:Int): Unit = {

        val expr = s"(1-x)^$order"
        val poly1 = UnivariateRing(Z, "x")(expr)

        /**
        coefficient array 
        */
        val coeff_seq = for (j <- 0 to order) yield ballot_num(n = order, j = j).toString

        /**
        coefficient sign array 
        */
        val sign_seq = for (j <- 0 to order) yield { (scala.math.pow(-1,j)) match {case -1 => "-" case 1 => "+" case _ => "error"} }

        /**
        full coefficient array 
        */
        val coeff_arr = (coeff_seq, sign_seq).zipped.map{ (a,b) => s"$b$a*x" }

        /**
        exponent array 
        */
        val exp_seq = for (j <- 0 to order) yield ((j*(j+1))/2).toString
         
        val poly2_arr = (exp_seq, coeff_arr).zipped.map{ (a,b) => s"$b^$a" }.mkString(" ")

        val poly2 = UnivariateRing(Z, "x")(poly2_arr)
        
        // final poly
        val final_poly = (poly2/%poly1)._1.toString.split("\\+")


        val distribution = for (p <- final_poly ) yield { p.replaceAll("\\*.*|x*.","") match {case "" => 1 case _ => p.replaceAll("\\*.*|x*.","")} }
        //val distribution = for (p <- final_poly ) yield { p.replaceAll("\\*.*|x*.","")  }
        println(distribution)

        }



    }    
}
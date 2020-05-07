
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


    def ballot_num(n: Int, j: Int): Double = {

        val t1: Double = (2.0*j +1.0)/(n + j + 1.0)
        
        val t2: Double = combinations(2*n, n+j)
        t1*t2 
        }

    def RiordanPolynomial(order:Int): Unit = {

        val expr = s"(1-x)^$order"
        val poly1 = UnivariateRing(Z, "x")(expr).toString

        /**
        coefficient array 
        */
        val coeff_seq = for (j <- 0 to order) yield ballot_num(n = order, j = j).toString
        println(coeff_seq)

        /**
        coefficient sign array 
        */
        val sign_seq = for (j <- 0 to order) yield { (scala.math.pow(-1,j)) }
        println(sign_seq)

        /**
        full coefficient array 
        */
        val coeff_arr = (coeff_seq, sign_seq).zipped.map{ (a,b) => s"$b*x^$a" }

        /**
        exponent array 
        */
        val exp_seq = for (j <- 0 to order) yield ((j*(j+1))/2).toString
        println(exp_seq)
        
        val poly2_arr = (exp_seq, coeff_seq).zipped.map{ (a,b) => s"$b*x^$a" }
        //val poly2_expr: String = poly2_arr.mkString(" + ")
        //val poly2 = UnivariateRing(Z, "x")(poly2_expr).toString
        println(poly2_arr)


        }



    }    
}
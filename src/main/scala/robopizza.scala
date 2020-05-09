
import analytic.RiordanGeneratingFunction

import breeze.linalg._
import breeze.numerics._

object ChordIntersectionDistribution {

    def main(args: Array[String]) {
        
        val analytic_sol = RiordanGeneratingFunction
        val analytic_distribution = analytic_sol.RiordanPolynomial(order = 4)
        
        val output = DenseMatrix(analytic_distribution)
        csvwrite(new java.io.File("test.csv"), output )

        


    }
}
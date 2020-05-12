
import analytic.RiordanGeneratingFunction

import com.github.tototoshi.csv._


object ChordIntersectionDistribution {

    def main(args: Array[String]) {
        
        val analytic_sol = RiordanGeneratingFunction
        val analytic_distribution: Array[Double] = analytic_sol.RiordanPolynomial(order = 4)

        // csv write 
        val f = new java.io.File("distribution_order_4.csv")
        val writer = CSVWriter.open(f)
        val output: List[List[Double]] = for (n <- analytic_distribution.toList) yield {List(n)}
        writer.writeAll(output)
        writer.close()
        


    }
}
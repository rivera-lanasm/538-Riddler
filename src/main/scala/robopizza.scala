
import analytic.RiordanGeneratingFunction
import com.github.tototoshi.csv._


object ChordIntersectionDistribution {

    def main(args: Array[String]) {

        val order: String = args(0)        
        val analytic_sol = RiordanGeneratingFunction
        val analytic_distribution: Array[Double] = analytic_sol.RiordanPolynomial(order = order.toInt)

        // csv write 
        val f = new java.io.File(f"distribution_order_$order.csv")
        val writer = CSVWriter.open(f)
        val output: List[List[Double]] = for (n <- analytic_distribution.toList) yield {List(n)}
        writer.writeAll(output)
        writer.close()

    }
}
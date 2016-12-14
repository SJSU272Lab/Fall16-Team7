import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf
import org.apache.spark.mllib.recommendation.ALS
import org.apache.spark.mllib.recommendation.Rating
import com.cmpe272._
import java.nio.file.{Paths, Files}
import java.nio.charset.StandardCharsets

object SimpleApp {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("Simple Application")
    val sc = new SparkContext(conf)
    // while(true)
    // {
    	//input data every 10m
        val pathr = SparkTest.fileGen()
    	val rawDataR = sc.textFile("00000data3.txt")
    	val rawIncomeRating = rawDataR.map(line => line.split("\\|").take(3))
    	val ratings = rawIncomeRating.map{
    	case Array(user, content, income) => Rating(content.toInt, user.toInt, income.toDouble)
    	}
    	val model = ALS.train(ratings, 50, 10, 0.01)
    	val topKRecs0 = model.recommendProducts(0, 100)
    	Files.write(Paths.get("file0.txt"), topKRecs0.mkString("\n").getBytes(StandardCharsets.UTF_8))
        SparkTest.mapFile("file0.txt")
    	val topKRecs1 = model.recommendProducts(1, 100)
    	Files.write(Paths.get("file1.txt"), topKRecs1.mkString("\n").getBytes(StandardCharsets.UTF_8))
    	SparkTest.mapFile("file1.txt")
        val topKRecs2 = model.recommendProducts(2, 100)
    	Files.write(Paths.get("file2.txt"), topKRecs2.mkString("\n").getBytes(StandardCharsets.UTF_8))
    	SparkTest.mapFile("file2.txt")
        val topKRecs3 = model.recommendProducts(3, 100)
    	Files.write(Paths.get("file3.txt"), topKRecs3.mkString("\n").getBytes(StandardCharsets.UTF_8))
        SparkTest.mapFile("file3.txt")
        // Thread.sleep(600000)
    // }
    sc.stop()
  }
}
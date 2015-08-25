package controllers;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.SQLContext;

import play.*;

/**
 * 
 * @author saharbenarfa
 * 
 *         One important aspect of the GlobalSettings class is that it provides
 *         a way to intercept requests and execute business logic before a
 *         request is dispatched to an action.
 * 
 *         Ps: It’s also possible to intercept a specific action method. This
 *         can be achieved via Action composition.
 *
 * 
 * 
 */
public class Global extends GlobalSettings {

	
static	JavaSparkContext ctx;
static SQLContext sqlContext ;
		

		

	// //Intercepting application start-up and shutdown
	//
	public void onStart(Application app) {
		Logger.info("Application has started");
		
		String host;
		String master;
		master = "local[4]";
		host = "localhost";
		SparkConf sparkConf = new SparkConf().setAppName("Analytics").setMaster(master)
				.set("spark.cassandra.connection.host", host);
		 ctx = new JavaSparkContext(sparkConf);
		 sqlContext = new SQLContext(ctx);
	}

	//
	public void onStop(Application app) {
		Logger.info("Application shutdown...");
		ctx.stop();

	}

}

package org.ledyba.simname

import scala.collection.mutable.HashMap

object Main {
	def main(args : Array[String]):Unit = {
		val lst = Place.load("KEN_ALL.csv");
		lst.filter(it => it.ruby.indexOf("イナリ") >= 0)
		.foldLeft(HashMap[String, Int]())( (hash, it) => {
			if( hash.contains(it.name) ) {
				hash(it.name) = hash(it.name)+1;
			}else{
				hash(it.name) = 1;
			}
		hash})
		.toList.sortWith( (it1,it2) => it1._2 > it2._2 ).foreach(println)
		
	}
}
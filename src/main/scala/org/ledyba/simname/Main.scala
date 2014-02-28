package org.ledyba.simname

object Main {
	def main(args : Array[String]):Unit = {
		println(Place.load("KEN_ALL.csv").length+" cities");
	}
}
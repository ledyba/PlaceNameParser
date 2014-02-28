package org.ledyba.simname

import scala.reflect.io.File
import scala.collection.mutable.ArrayBuffer
import javax.naming.directory.InvalidAttributesException
import scala.collection.mutable.HashMap
import java.lang.Boolean
import scala.collection.mutable.HashSet
import com.ibm.icu.text.Transliterator

case class Place(pref:String, name:String, ruby:String) {
}

object Place {
	def load(fname:String):Array[Place] = load(File(fname));
	def removeQ(str : String) = str drop 1 dropRight 1;
	def load(f:File):Array[Place] = {
		val br = f.bufferedReader(scala.io.Codec("Shift-JIS"));
		var line:String=br.readLine();
		val lst:ArrayBuffer[Place] = ArrayBuffer[Place]();
		val chash = HashSet[String]();
		val nhash = HashSet[String]();
		val tr = Transliterator.getInstance("Halfwidth-Fullwidth");
		def normalize(str:String) = {
			val s = removeQ(str);
			val idx1 = s.indexOf("（");
			val idx2 = s.indexOf("(");
			val idx = Math.max(idx1,idx2);
			tr.transform(if(idx < 0) s else s.substring(0, idx));
		}
		
		while(null != line){
			line.split(",").toList match {
			case _ :: _ :: _ :: pref_ruby_ :: city_ruby_ :: ruby_ :: pref_ :: city_ ::name_ :: _ => {
				val pref = normalize(pref_);
				val pref_ruby = normalize(pref_ruby_);
				val city = normalize(city_);
				val city_ruby = normalize(city_ruby_);
				val name = normalize(name_);
				val ruby = normalize(ruby_);
				if( !chash.contains(pref+city) ) {
					lst += Place(pref, city, city_ruby);
					chash.add(pref+city);
				}
				val nkey = pref+city+name;
				if( !nhash.contains(nkey) && name!="以下に掲載がない場合" ){
					lst += Place(pref, name, ruby);
					println(nkey+"/"+ruby+"/"+ruby.size);
					nhash.add(nkey);
				}
			}
			case _ => throw new InvalidAttributesException("File broken.");
			}
			line = br.readLine();
		}
		return lst.toArray;
	}
}
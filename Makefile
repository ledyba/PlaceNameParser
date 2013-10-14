
all:
	sbt compile

jar:
	sbt assembly

run:
	sbt run

reload:
	sbt reload update eclipse

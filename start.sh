javac -d out src/com/game/xo/common/*.java
javac -d out src/com/game/xo/players/*.java
javac -sourcepath ./src -d out src/com/game/xo/main/*.java

java -classpath ./out com.game.xo.main.Main

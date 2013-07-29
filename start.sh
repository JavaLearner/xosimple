javac -d out src/com/game/xo/players/*.java
javac -d out src/com/game/xo/common/GameAlgorithm.java

javac -sourcepath ./src -d out src/com/game/xo/common/InitializeGame.java
javac -sourcepath ./src -d out src/com/game/xo/common/StartGame.java
javac -sourcepath ./src -d out src/com/game/xo/main/Main.java

java -classpath ./out com.game.xo.main.Main

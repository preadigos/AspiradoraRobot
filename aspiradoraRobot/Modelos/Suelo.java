����   ; X
      java/lang/Object <init> ()V	  	 
   Modelos/Suelo tieneObstaculo Z	     
estaLimpio  java/util/HashMap
  	     bordes Ljava/util/Map;
     inicializarBordes  derecha
      ! java/lang/Boolean valueOf (Z)Ljava/lang/Boolean; # $ % & ' java/util/Map put 8(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; ) 	izquierda + arriba - abajo	 / 0 1 2 3 java/lang/System out Ljava/io/PrintStream; 5 X
 7 8 9 : ; java/io/PrintStream print (Ljava/lang/String;)V = L ? S 	Signature 6Ljava/util/Map<Ljava/lang/String;Ljava/lang/Boolean;>; Code LineNumberTable LocalVariableTable this LModelos/Suelo; mostrarSuelo StackMapTable getTieneObstaculo ()Z setTieneObstaculo (Z)V getEstaLimpio setEstaLimpio 	getBordes ()Ljava/util/Map; 8()Ljava/util/Map<Ljava/lang/String;Ljava/lang/Boolean;>; 	setBordes (Ljava/util/Map;)V LocalVariableTypeTable 9(Ljava/util/Map<Ljava/lang/String;Ljava/lang/Boolean;>;)V 
SourceFile 
Suelo.java !                    @    A 	     B   \     *� *� *� *� Y� � *� �    C          	        D        E F       B   {     A*� � � " W*� (� � " W*� *� � " W*� ,� � " W�    C             0  @  D       A E F    G   B   �     4*� � � .4� 6� $*� � � .<� 6� *� � � .>� 6�    C              $  +  3 ! D       4 E F   H      I J  B   /     *� �    C       % D        E F    K L  B   >     *� �    C   
    )  * D        E F          M J  B   /     *� �    C       - D        E F    N L  B   >     *� �    C   
    1  2 D        E F          O P  B   /     *� �    C       5 D        E F   @    Q  R S  B   P     *+� �    C   
    9  : D        E F         T         A  @    U  V    W
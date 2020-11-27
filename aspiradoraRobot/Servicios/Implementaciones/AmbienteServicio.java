����   ; Y
      java/lang/Object <init> ()V  Modelos/Ambiente
  
   (II)V	      +Servicios/Implementaciones/AmbienteServicio ambiente LModelos/Ambiente;
     getAmbiente ()[[LModelos/Suelo;  Modelos/Suelo
  
     ubicarObstaculos
     determinarBordes
   ! " # $ java/lang/Math random ()D@       
  ( ) * setTieneObstaculo (Z)V
  , - . 	getBordes ()Ljava/util/Map; 0 arriba
 2 3 4 5 6 java/lang/Boolean valueOf (Z)Ljava/lang/Boolean; 8 9 : ; < java/util/Map replace 8(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; > abajo @ 	izquierda B derecha D Servicios/iAmbiente Code LineNumberTable LocalVariableTable this -LServicios/Implementaciones/AmbienteServicio; filas I columnas inicializarAmbiente j i StackMapTable valorRandomFila valorRandomColumna cantidadSuelo D obtenerAmbienteSuelo ()LModelos/Ambiente; 
SourceFile AmbienteServicio.java !    C            E   X     *� *� Y� 	� �    F            G         H I      J K     L K   M   E   �     E<*� � �� 1=*� � 2�� *� � 2� Y� S���݄���*� *� �    F   "         0  6  <  @  D  G       & N K   : O K    E H I   P    � � � %�      E   �     f*� � �*� � 2�h�H>�� 'k�� F� *� � �� %gkc�6� *� � �� %gkc�6*� � 22� '�����    F          "  8   N " _  e $ G   4  8 ' Q K  N  R K   N O K    f H I    Q S T  P   
 � � M     E       �<*� � �� F*� � 22� +/� 1� 7 W*� � *� � �d22� +=� 1� 7 W����<*� � 2�� H*� � 22� +?� 1� 7 W*� � 2*� � 2�d2� +A� 1� 7 W�����    F   & 	   (  ) ( * K ( Q - a . { / � - � 1 G       O O K  S S O K    � H I   P    � � N� � R  U   E   2     *� � �    F       5 G        H I     V  E   /     *� �    F       : G        H I    W    X
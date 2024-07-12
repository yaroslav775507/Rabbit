<h1 align="center">Hi there, I'm <a href="https://t.me/Yaroslav07" target="_blank">Ярослав</a> 
<img src="https://github.com/blackcater/blackcater/raw/main/images/Hi.gif" height="140"/></h1>
<h3 align="center">Java developer from Russia🇷🇺</h3>


<h3>Задача такая "Составить эффективный алгоритм"</h3>
<p>Есть 5 полянок. На каждой полянке огород с морковкой.
На первой полянке морковь массой в 1 кг, на второй полянке - морковь массой в 2 кг, 
на третьей полянке - морковь массой в 3 кг, на 4 полянке - морковь массой в 4 кг, 
на пятой полянке - морковь массой в 5 кг. Зайцу необходимо за 10 ходок унести максимальное количество 
моркови с полянок за 1 день, причем заяц за раз может взять только 5 кг моркови. Необходимо составить 
эффективный алгоритм, который самостоятельно должен найти решение на Java. 
Преимуществом будет не только составить алгоритм, но программный код, который можно будет проверить.</p>
<p>Для реализации я воспользовался алгоритмом, который ищет сначала минимальный элемент, так как минимальный вес в массиве является оптимальным.</p>



    public static int CarrotAlg(Carrot carrot) throws IOException {

    int general = 0;
    try {
    
        int[] weights = carrot.getWeight();
        
        // Validate weights: all elements must be positive
        for (int i = 0; i < weights.length; i++) {
            if (weights[i] <= 0) {
                throw new IllegalArgumentException("Есть нулевой/отрицательный элемент");
            }
        }
        
        // Find the minimum weight
        int min = weights[0];
        for (int i = 1; i < weights.length; i++) {
            if (weights[i] < min) {
                min = weights[i];
            }
        }
        
        // Calculate general if the minimum weight is positive
        if (min > 0) {
            general = carrot.getMaxWeight() / min;
        } else {
            throw new ArithmeticException("Есть нулевой/отрицательный элемент");
        }

    } catch (IllegalArgumentException | ArithmeticException e) {
        System.err.println("Error: " + e.getMessage());
        return -1;
    } catch (Exception e) {
        e.printStackTrace();
        return -1;
    }
    
    return general * carrot.getWalking();
    }
<p>А так же покрыл решение тестами для отработки ошибок</p>

     @Test
        void testValidWeights() throws IOException {
            Carrot carrot = new Carrot(new int[]{5, 10, 15}, 30, 2);
            int result = CarrotAlg(carrot);
            Assertions.assertEquals(12, result);
        }

    @Test
    void testZeroWeight() throws IOException {
        Carrot carrot = new Carrot(new int[]{0, 10, 15}, 30, 2);
        int result = CarrotAlg(carrot);
        Assertions.assertEquals(-1, result);
    }

    @Test
    void testNegativeWeight() throws IOException {
        Carrot carrot = new Carrot(new int[]{-5, 10, 15}, 30, 2);
        int result = CarrotAlg(carrot);
        Assertions.assertEquals(-1, result);
    }

    @Test
    void testEmptyWeights() throws IOException {
        Carrot carrot = new Carrot(new int[]{}, 30, 2);
        int result = CarrotAlg(carrot);
        Assertions.assertEquals(-1, result);
    }

    @Test
    void testGeneralCalculation() throws IOException {
        Carrot carrot = new Carrot(new int[]{1, 1, 1}, 3, 1);
        int result = CarrotAlg(carrot);
        Assertions.assertEquals(3, result);
    }

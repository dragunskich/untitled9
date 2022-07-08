public class EntityManagerNotClose extends RuntimeException {

        public EntityManagerNotClose() {
            super ("Не удается найти страну для добавления");
        }
        public EntityManagerNotClose(String message) {
            super(message);
        }


}

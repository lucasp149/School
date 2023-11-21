package classes;



    abstract class Furniture implements IDepositWork, IQualityControl {
        public String color;
        public boolean isNew;
        public boolean needChange;
        protected int assignedToClassroom;

        public Furniture (int assignedToClassroom, String color, boolean isNew, boolean needChange) {
            this.color = color;
            this.assignedToClassroom = assignedToClassroom;
            this.isNew = isNew;
            this.needChange = needChange;
        }

        // method
        public void changeAssignedToClassroom(int newClassroom) {
            assignedToClassroom = newClassroom;
        }

        @Override
        public void paint (String color) throws BadPaintColorsException {
            boolean okColor = false;
            for(String s : availableColors){
                if (color.equals(s)) {
                    okColor = true;
                    break;
                }
            }
            if(okColor){
                this.color = color;
            }
            else {
                throw new BadPaintColorsException("The color you choose is not in the available colors list");
            }
        }

        // this method cannot be overridden
        @Override
        public final void declareBadCondition(){
            this.needChange = true;
            this.isNew = false;
            changeAssignedToClassroom(0);
        }
    }


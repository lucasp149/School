package classes;



    abstract class Furniture implements IDepositWork, IQualityControl {
        public String color;
        public boolean isNew;
        public boolean needChange;
        protected int assignedToClassroom;

        public Furniture (int _assignedToClassroom, String _color, boolean _isNew, boolean _needChange) {
            color = _color;
            assignedToClassroom = _assignedToClassroom;
            isNew = _isNew;
            needChange = _needChange;
        }

        // method
        public void changeAssignedToClassroom(int _newClassroom) {
            assignedToClassroom = _newClassroom;
        }

        @Override
        public void paint (String _color) throws PaintColorsException {
            boolean okColor = false;
            for(String s : availableColors){
                if (_color.equals(s)) {
                    okColor = true;
                    break;
                }
            }
            if(okColor){
                this.color = _color;
            }
            else {
                throw new PaintColorsException("The color you choose is not in the available colors list");
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


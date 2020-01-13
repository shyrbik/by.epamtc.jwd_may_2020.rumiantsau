package by.it.cherkas.jd01_07;

        class Vector extends AbstractVar {

                private double[] value;


                 Vector(double[] value) {
                        this.value = value;

                }
                Vector(Vector vector){
                         this.value=vector.value;
                }

                Vector(String strVector){
                     //   this.value=new double;
                }


                @Override
                public String toString() {
                StringBuilder sb=new StringBuilder();
                sb.append("{");
                String del="";
                        for (double element:value ) {
                        sb.append(del);
                        sb.append(element);
                        del=",";
                        }
                        sb.append("}");
                        return sb.toString();
                }
        }





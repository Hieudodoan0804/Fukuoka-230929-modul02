package lythuyet.vidu;

import java.util.Arrays;
import java.util.Objects;

public class manager {
 private BaseEntity[] entities;
 private int defaultEl = 5;
 private int index = 0;
 public Manager(){
  this.entities = new BaseEntity[defaultEl];
 }
 public void add(BaseEntity item){
  if(index==entities.length){
   entities = Arrays.copyOf(entities,entities.length+defaultEl);
  }
  entities[index++]=item;
 }
 public void show(){
  for (int i =0; i<index;i++){
   entities[i].show();
  }
 }

 public BaseEntity findId(Object id){
  for (int i =0; i<index;i++){
   if (entities[i].checkId(id)){
    return entities[i];
   }
  }
  return null;
 }
 /**
  * Hoàn thiện phương thức để có thể tìm kiếm entity theo bất kỳ điều kiện nào
  * Tham số tự chọn
  * @return
  */
 public BaseEntity findFirst(Predicated predicated) {
  for (int i = 0; i < index;i++){
   if (predicated.condition(entities[i])){
    return entities[i];
   }
  }
  return null;
 }

}

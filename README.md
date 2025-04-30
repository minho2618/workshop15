# workshop15
1. workshop14 ArrayList ---> HashMap
2. 강력한 제어문을 사용
   UserException
   1) Book이 이미 존재할 때
   2) 삭제하거나 수정할 대상이 없을 때
   3) 비지니스 로직과 관련된 또 다른 예외클래스

3. ~ManagerImpl 클래스에서는 기능 위주로 작성된 클래스이기때문에
  예외발생시 즉각적인 처리하지말고 throws 사용해서 던진다.
4. ~Test클래스에서 기능 호출마다 각각 예외를 즉각적으로 처리한다

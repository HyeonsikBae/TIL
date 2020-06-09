## Package

- 패키지

__프로젝트는 패키지의 모음__, __패키지는 클래스의 모음__이다.

__패키지__란, 비슷한 성격의 클래스들을 모아 놓는 일종의 폴더같은 것이라고 이해하면 된다.

패키지 하위에 서브 패키지를 계속 만들 수도 있다.

![image-20200527105138768](C:\Users\bitcamp\AppData\Roaming\Typora\typora-user-images\image-20200527105138768.png)



아래 디렉토리를 예를 들면 다음과 같이 생각할 수 있다.

![image-20200527105845175](C:\Users\bitcamp\AppData\Roaming\Typora\typora-user-images\image-20200527105845175.png)

Project : Samsung smartphone

Package : A Series, Signiture

Sub Package : Note series, S series

Class : A10, A30, A50, Note 9, Note 10, Note 10+, S10, S10e, S10 5G



자바와 같은 객체지향 언어의 장점이 무엇인가.

타 패키지 내의 클래스를 참조하여 객체를 생성할 수 있다.

이 때,

import PackageName.ClassName 를 통해 __참조__하여야 하며,

import PackageName.* 을 통해 해당 패키지 내부의 모든 클래스를 __참조__할 수도 있다.
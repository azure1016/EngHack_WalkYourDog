## What's the idea? 
Match with an awesome person who can walk your dog when you don't have time! Or find a dog to light up your day without taking on too many responsibilities!



## Inspiration

Dogs are adorable and amazing! A puppy could be the best gift in our life. However, dog ownership means commitment and long-term responsibility. What's more, sometimes it can be hard to find time every day to walk your dog. Why not find a motivated helper rather than keep your dog stuck indoors? 

On the other hand, many dog lovers are waiting for the right time to own a dog. This is a perfect chance to spend time around a loving pup! By helping dog owners walk their dogs, dog lovers can not only have a fun time but also get a taste of what kind of dogs fit them best. 

## What it does

To solve this problem, we developed an Android mobile application. Registered dog owners and dog lovers can choose a time slot and then swipe the users based on their preference.  When a dog owner and a dog lover mutually like each other, they can start a conversation and negotiate details about time and location for dog walking.


## How we built it
Language: JAVA

Tools: Android-Studio, IntelliJ IDEA

Frameworks: Retrofit2, OKhttp, RxJava, Spring-Boot, Mybatis

Database: MySQL

Running environment: Google Cloud Platform

Version Control: Github

First, we defined the product needs, including requirement analysis and UI design. The requirements specified what to implement and the functionality of each component. For UI design, we chose yellow for our colour palette to help convey energy and action. 

In our software architecture, we created a front and rear end to organize code and provide modularity. The back-end runs with spring-boot and provides a series of RESTful APIs. 

## Challenges we ran into
1. Inefficient team member communication. Each team member had a different understanding of the goals of the project. Each part was built on an individual's perspective. We should have communicated with each other and exchanged ideas in written format more frequently during the hackthon.
2. Integrate the back end with the front end, and deploy the backend service on Google Cloud Platform so that the application could be made use in real life.




## Accomplishments that we're proud of
1. We can successfully run our code and operate our Andriod app on Emulator! We built the login/register layout, timeslot selection function and user communication layout. Finally, we implemented the swipe to like or dislike function.

2. The architecture conformed to popular practices in the industry: we separated the front end and the back end, and implemented RESTful API to conduct connections between front ends and the back end; we also succeeded in deploying it on Google Cloud Platform.

3. Awesome teamwork! Everyone's good at something: Betty came up with an awesome proposal -- the lovely idea of building such an application -- and made the app logos and collected resources of pictures, and helped with the documentations; Yuxin built the backend and deplyed the Jar on GCP, Muhan built the front end application and Dan implemented the Restful API. We worked very efficiently!

## What we learned
1. Git saves the world.
2. Build an Andriod app to a higher level.
3. How to deploy an Andriod app on Google Cloud platform。
4. Better understanding of Restful API, better practice in software development (requirement analysis, etc).
5. Documentation and requirement analysis are powerful! If you want better groupwork and better results, definitely make a consensus with documentations before and after the development.

## What's next for Walk Your Dog
1. Filter users based on location.
2. Add a tracking function with APIs of maps to ensure the safety of the dog. 
3. Implement a user rating system.
4. A dog recommendation system for registered dog lovers (machine learning).
5. Maybe we can even come up with a business plan!

# RESTful API usage documentation

POST /timeslot  

create timeslot for volunteer and dog

---

**parameters**:


```
time=2019-06-22-SAT-M			

// M->morning ; A->afternoon; E->evening
        
dogid=?

volunteerid=?
```

**sample**

http://localhost:8080/timeslot?time=2019-06-23-SAT-M&volunteerid=voln10

**return**:

    {
        “status”: 200
    }


GET		/timeslot	

search timeslot for dog and volinteer

---


**parameters**:


```
time=?

volunteerid=? (optional)

dogid=? (optional)

//volunteerid and dogid cannot be empty at the same time
```

**sample**

http://localhost:8080/timeslot?time=2019-06-23-SAT-M&volunteerid=voln10

**return**:

```
{
    "status": "200",
    "data": [
        {
            "id": "dog1",
            "name": "dogname1",
            "rating": "10",
            "img": "img1"
        }
    ]
}

```

**sample**

http://localhost:8080/timeslot?time=2019-06-23-SAT-M&dogid=dog2

**return**:

```
{
    "status": "200",
    "data": [
        {
            "id": "voln1",
            "name": "volnname1",
            "rating": "8",
            "img": "img"
        },
        {
            "id": "voln4",
            "name": "volnname1",
            "rating": "8",
            "img": "img"
        },
        {
            "id": "voln1",
            "name": "volnname1",
            "rating": "8",
            "img": "img"
        }
    ]
}
```


POST 	/likeDog    

create mapping from volunteer to dog

---

**Parameters**:

```
dogid=?
volunteerid=?
```

**sample**

http://localhost:8080/timeslot?dogid=dog2&volunteerid=voln1

**return**:

```
{
“status”: 200
}
```

POST 	/likeVoln    

create mapping from dog to volunteer

---

**Parameters**:

```
dogid=?
volunteerid=?
```

**sample**

http://localhost:8080/timeslot?dogid=dog2&volunteerid=voln1

**return**:

```
{
“status”: 200
}
```

GET /like   

get mapping of dog or volunteer in like

**Parameters**:

```
dogid=?
volunteerid=?
```

**sample**

http://localhost:8080/like?dogid=dog2

**return**

```
{
    "status": "200",
    "data": [
        {
            "id": "voln1",
            "name": "volnname1",
            "rating": "8",
            "img": "img"
        },
        {
            "id": "voln4",
            "name": "volnname1",
            "rating": "8",
            "img": "img"
        }
    ]
}

```

http://localhost:8080/like?volunteerid=voln2

**return**

```
{
    "status": "200",
    "data": [
        {
            "id": "voln2",
            "name": "volnname1",
            "rating": "8",
            "img": "img"
        }
    ]
}
```


POST	/dog	

create profile for dog


---

**body**:

```

	{
		"id"="dog2",
		"name”="dododo",
		"rating"=9,
		"img"="img"
	}

```

**return**:

```
{
    "status":200
}
```

POST	/volunteer	 

create profile for volunteer

---

**body**:

```

	{
		"id"="voln2",
		"name"="vovovo",
		"rating"=9,
		"img"="img"
	}

```

**return**:

```
{
    "status":200
}
```
		

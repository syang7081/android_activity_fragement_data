# Propagate Activity Lifecycle State To All Its Fragements
A project to demo how to pass the state and data of an activity to its direct fragments and nested fragments without using any callbacks
or messages. By introducing base classes for an activity and its fragements, all fragments in an activity can be tracked through weak refrence.
An activity's lifecycle state is passed to its fragements by invoking the postData method of the base class BaseFragment.   

# Propagate Activity Data and State To All Its Fragements
A project to demo how to pass the data and state of an activity to its direct fragments and nested fragments without using any callbacks
or messages. By introducing base classes for an activity and its fragements, all fragments in an activity can be tracked through weak refrence.
An activity's data and state can be passed to its fragements by invoking the postData method defined in the base actvity and the base fragment.

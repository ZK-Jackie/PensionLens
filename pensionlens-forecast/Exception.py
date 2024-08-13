class NumConvertError(Exception):
    def __init__(self, num):
        self.num = num
    def __str__(self):
        return "The number %s can not be converted." % self.num
    class StringConvertError(Exception):
        def __init__(self, string):
            self.string = string
        def __str__(self):
            return "The string %s can not be converted." % self.string
    class IntegerConvertError(Exception):
        def __init__(self, integer):
            self.integer = integer
        def __str__(self):
            return "The integer %s can not be converted." % self.integer
import unittest

from FourBasicOpt import FourBasicOpt


class FourBasicOptTest(unittest.TestCase):
    def setUp(self):
        self.calc = FourBasicOpt()

    def test_add_two_positive_numbers(self):
        self.assertEqual(self.calc.add(100, 10), 110)

    def test_add_negative_number(self):
        self.assertEqual(self.calc.add(100, -10), 90)

    def test_subtract_positive_number(self):
        self.assertEqual(self.calc.subtract(100, 10), 90)

    def test_subtract_negative_number(self):
        self.assertEqual(self.calc.subtract(100, -10), 110)

    def test_divide_by_nonzero_number(self):
        self.assertEqual(self.calc.divide(100, 10), 10)

    def test_divide_by_zero_returns_zero(self):
        self.assertEqual(self.calc.divide(100, 0), 0)

    def test_multiply_by_one(self):
        self.assertEqual(self.calc.multiply(100, 1), 100)

    def test_multiply_two_positive_numbers(self):
        self.assertEqual(self.calc.multiply(100, 10), 1000)


if __name__ == "__main__":
    unittest.main(verbosity=2)

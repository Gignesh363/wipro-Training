// ChessTournamentForm.jsx
import React, { useState } from "react";
import { Formik, Form, Field, ErrorMessage } from "formik";
import * as Yup from "yup";
import "bootstrap/dist/css/bootstrap.min.css";

// Validation Schema using Yup
const validationSchema = Yup.object().shape({
  playerName: Yup.string().min(3, "Min 3 characters").required("Required"),
  dob: Yup.date()
    .max(new Date(new Date().setFullYear(new Date().getFullYear() - 5)), "Too young")
    .min(new Date(new Date().setFullYear(new Date().getFullYear() - 90)), "Too old")
    .required("Required"),
  gender: Yup.string().required("Required"),
  fideId: Yup.string().length(8, "Must be 8 digits").required("Required"),
  rating: Yup.number().min(100).max(3000).required("Required"),
  email: Yup.string().email("Invalid email").required("Required"),
  mobile: Yup.string()
    .matches(/^[6-9]\d{9}$/, "Must be valid 10-digit number")
    .required("Required"),
  country: Yup.string().required("Required"),
  category: Yup.string().required("Required"),
  parentContact: Yup.string().when("category", {
    is: "Under 12",
    then: Yup.string()
      .matches(/^[6-9]\d{9}$/, "Must be valid 10-digit number")
      .required("Required"),
  }),
  paymentConfirmed: Yup.boolean().oneOf([true], "Payment confirmation required"),
  terms: Yup.boolean().oneOf([true], "You must accept terms"),
});

export default function ChessTournamentForm() {
  const [submittedData, setSubmittedData] = useState([]);

  return (
    <div className="container mt-4">
      <h2 className="text-center mb-4">Chess Tournament Registration</h2>

      <Formik
        initialValues={{
          playerName: "",
          dob: "",
          gender: "",
          fideId: "",
          rating: "",
          email: "",
          mobile: "",
          country: "",
          category: "",
          parentContact: "",
          paymentConfirmed: false,
          terms: false,
        }}
        validationSchema={validationSchema}
        onSubmit={(values, { resetForm }) => {
          console.log("Submitted Data:", values);
          setSubmittedData([...submittedData, values]);
          resetForm();
        }}
      >
        {({ values }) => (
          <Form className="card p-4 shadow-lg">
            {/* Player Name */}
            <div className="mb-3">
              <label>Player Name</label>
              <Field name="playerName" className="form-control" />
              <ErrorMessage name="playerName" component="div" className="text-danger" />
            </div>

            {/* Date of Birth */}
            <div className="mb-3">
              <label>Date of Birth</label>
              <Field type="date" name="dob" className="form-control" />
              <ErrorMessage name="dob" component="div" className="text-danger" />
            </div>

            {/* Gender */}
            <div className="mb-3">
              <label>Gender</label>
              <Field as="select" name="gender" className="form-select">
                <option value="">Select</option>
                <option value="Male">Male</option>
                <option value="Female">Female</option>
                <option value="Other">Other</option>
              </Field>
              <ErrorMessage name="gender" component="div" className="text-danger" />
            </div>

            {/* FIDE ID */}
            <div className="mb-3">
              <label>FIDE ID</label>
              <Field name="fideId" className="form-control" />
              <ErrorMessage name="fideId" component="div" className="text-danger" />
            </div>

            {/* Rating */}
            <div className="mb-3">
              <label>Rating</label>
              <Field type="number" name="rating" className="form-control" />
              <ErrorMessage name="rating" component="div" className="text-danger" />
            </div>

            {/* Email */}
            <div className="mb-3">
              <label>Email</label>
              <Field type="email" name="email" className="form-control" />
              <ErrorMessage name="email" component="div" className="text-danger" />
            </div>

            {/* Mobile */}
            <div className="mb-3">
              <label>Mobile</label>
              <Field name="mobile" className="form-control" />
              <ErrorMessage name="mobile" component="div" className="text-danger" />
            </div>

            {/* Country */}
            <div className="mb-3">
              <label>Country</label>
              <Field name="country" className="form-control" />
              <ErrorMessage name="country" component="div" className="text-danger" />
            </div>

            {/* Category */}
            <div className="mb-3">
              <label>Category</label>
              <Field as="select" name="category" className="form-select">
                <option value="">Select</option>
                <option value="Under 12">Under 12</option>
                <option value="Under 18">Under 18</option>
                <option value="Open">Open</option>
              </Field>
              <ErrorMessage name="category" component="div" className="text-danger" />
            </div>

            {/* Parent Contact (only if Under 12) */}
            {values.category === "Under 12" && (
              <div className="mb-3">
                <label>Parent Contact</label>
                <Field name="parentContact" className="form-control" />
                <ErrorMessage name="parentContact" component="div" className="text-danger" />
              </div>
            )}

            {/* Payment Confirmation */}
            <div className="form-check mb-3">
              <Field type="checkbox" name="paymentConfirmed" className="form-check-input" />
              <label className="form-check-label">Payment Confirmed</label>
              <ErrorMessage name="paymentConfirmed" component="div" className="text-danger" />
            </div>

            {/* Terms */}
            <div className="form-check mb-3">
              <Field type="checkbox" name="terms" className="form-check-input" />
              <label className="form-check-label">Accept Terms & Conditions</label>
              <ErrorMessage name="terms" component="div" className="text-danger" />
            </div>

            <button type="submit" className="btn btn-primary w-100">
              Submit
            </button>
          </Form>
        )}
      </Formik>

      {/* Submitted Data Table */}
      {submittedData.length > 0 && (
        <div className="mt-5">
          <h4>Registered Players</h4>
          <table className="table table-bordered table-striped">
            <thead>
              <tr>
                <th>Name</th>
                <th>DOB</th>
                <th>Gender</th>
                <th>FIDE ID</th>
                <th>Rating</th>
                <th>Email</th>
                <th>Mobile</th>
                <th>Country</th>
                <th>Category</th>
                <th>Parent Contact</th>
              </tr>
            </thead>
            <tbody>
              {submittedData.map((player, index) => (
                <tr key={index}>
                  <td>{player.playerName}</td>
                  <td>{player.dob}</td>
                  <td>{player.gender}</td>
                  <td>{player.fideId}</td>
                  <td>{player.rating}</td>
                  <td>{player.email}</td>
                  <td>{player.mobile}</td>
                  <td>{player.country}</td>
                  <td>{player.category}</td>
                  <td>{player.parentContact}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      )}
    </div>
  );
}
